<?php
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $userName = htmlspecialchars($_POST['userName']);
    $userEmail = htmlspecialchars($_POST['userEmail']);
    $userPassword = htmlspecialchars($_POST['userPassword']);
    $userAge = (int)$_POST['userAge'];
    $musicGenre = htmlspecialchars($_POST['musicGenre']);

    if (empty($userName) || empty($userEmail) || empty($userPassword) || $userAge <= 0 || empty($musicGenre)) {
        echo "Please fill out all fields correctly.";
        exit;
    }

    $host = 'localhost';
    $dbName = 'college';
    $username = 'root';
    $password = '';

    try {
        $pdo = new PDO("mysql:host=$host;dbname=$dbName", $username, $password);
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        $createTableSQL = "CREATE TABLE IF NOT EXISTS songs (
            id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(255) NOT NULL,
            email VARCHAR(255) NOT NULL UNIQUE,
            password VARCHAR(255) NOT NULL,
            age INT NOT NULL,
            genre VARCHAR(255) NOT NULL,
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        )";
        $pdo->exec($createTableSQL);

        $insertSQL = "INSERT INTO users (name, email, password, age, genre) VALUES (:name, :email, :password, :age, :genre)";
        $stmt = $pdo->prepare($insertSQL);
        $stmt->execute([
            ':name' => $userName,
            ':email' => $userEmail,
            ':password' => password_hash($userPassword, PASSWORD_BCRYPT),
            ':age' => $userAge,
            ':genre' => $musicGenre
        ]);

        header("Location: ex6_home.php");
        exit;
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
}
?>
