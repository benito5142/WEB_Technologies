<?php
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Groovy</title>
    <link rel="stylesheet" href="ex6_home.css">
</head>
<body>
    <div class="main">
        <div class="d2">
            <div class="d3">
                <div class="library-title">Groovy</div>
                <a href="ex6_profile.php" class="profile-icon-link">
                    <div class="profile-icon">👤</div>
                </a>
            </div>

            <div class="d4">
                <?php 
                $categories = [
                    'Pop', 'Rock', 'Jazz', 'Hip Hop', 'Classical', 'Blues', 'Country', 'Electronic'
                ];
                foreach ($categories as $category) { 
                ?>
                    <div class="category-tile">
                        <a href="ex6_genre.php?genre=<?php echo urlencode($category); ?>">
                            <img src="https://via.placeholder.com/150" alt="Category Image" class="category-image">
                            <div class="category-name"><?php echo $category; ?></div>
                        </a>
                    </div>
                <?php } ?>
            </div>

            <!-- Popular Songs Section -->
            <div class="popular-section">
                <h2 style="font-size: 2em;">Popular Songs</h2>
                <div class="popular-songs">
                    <?php 
                    $songs = [
                        ["Electric Love", "Borns", "images/electric love.jpg", "https://open.spotify.com/track/2GiJYvgVaD2HtM8GqD9EgQ"],
                        ["FEIN", "Travis Scott, Playboi Carti", "images/fein.jpg", "https://open.spotify.com/track/42VsgItocQwOQC3XWZ8JNA"],
                        ["Do I Wanna Know", "Arctic Monkeys", "images/do i wanna know.jpg", "https://open.spotify.com/track/5FVd6KXrgO9B3JPmC8OPst"],
                        ["Here", "Alessia Shah", "images/here.jpg", "https://open.spotify.com/track/5LrN7yUQAzvthd4QujgPFr"],
                        ["Jericho", "Iniko", "images/jericho.jpg", "https://open.spotify.com/track/4ztdjZ2t7BVo5DLIFQBdJh"],
                        ["Astronaut In The Ocean", "Masked Wolf", "images/astronaut in the ocean.jpg", "https://open.spotify.com/album/7vus4Q8r5DS2Dl1JClxEsA"],
                        ["Promiscuous", "Nelly Furtado, Timbaland", "images/promiscuous.jpg", "https://open.spotify.com/track/2gam98EZKrF9XuOkU13ApN"],
                        ["Swim", "Chase Atlantic", "images/swim.jpg", "https://open.spotify.com/track/3M0lSi5WW79CXQamgSBIjx"],
                        ["Gurenge", "LiSA", "images/gurenge.jpg", "https://open.spotify.com/track/0qMip0B2D4ePEjBJvAtYre"]
                    ];

                    foreach ($songs as $song) { 
                        [$title, $artist, $image, $link] = $song;
                    ?>
                    <div class="popular">
                        <a href="<?php echo $link; ?>">
                            <img class="cover" src="<?php echo $image; ?>" alt="<?php echo $title; ?>">
                        </a>
                        <a href="<?php echo $link; ?>" class="popular-song-name"><?php echo $title; ?></a>
                        <div class="popular-singer-name"><?php echo $artist; ?></div>
                    </div>
                    <?php } ?>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
