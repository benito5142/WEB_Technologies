<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "songs";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$user_id = $_GET['user_id'];

$sql = "SELECT * FROM users WHERE id = $user_id";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo "<h1>Profile Page</h1>";
        echo "<p>Name: " . $row["name"]. "</p>";
        echo "<p>Email: " . $row["email"]. "</p>";
        echo "<p>Favorite Song: " . $row["favorite_song"]. "</p>";
    }
} else {
    echo "0 results";
}

$conn->close();
?>