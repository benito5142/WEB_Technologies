<?php
$genre = isset($_GET['genre']) ? $_GET['genre'] : 'Unknown Genre';

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $genre; ?> - Groovy</title>
    <link rel="stylesheet" href="ex6_home.css">
</head>
<body>
    <div class="main">
        <div class="d2">
            <div class="d3">
                <div class="library-title"><?php echo $genre; ?> Music</div>
                <div class="genre-content">
                    <p>Displaying content for the genre: <?php echo $genre; ?></p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
