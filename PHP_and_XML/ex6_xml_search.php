<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f9f9f9;
        color: #333;
    }

    .song-result {
        background-color: #fff;
        border: 1px solid #ddd;
        border-radius: 8px;
        margin: 10px 0;
        padding: 15px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        transition: transform 0.2s ease;
    }

    .song-result:hover {
        transform: scale(1.02);
    }

    .song-name {
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 5px;
        color: #007bff;
    }

    .song-details {
        font-size: 14px;
        color: #444;
    }

    p {
        font-size: 16px;
        color: #666;
    }
</style>

<?php
    if (isset($_GET['song_name']) && !empty(trim($_GET['song_name']))) {
        $searchQuery = htmlspecialchars(trim($_GET['song_name']));
        echo "<p>Search Query: <strong>" . $searchQuery . "</strong></p>";
    } else {
        echo "<p>Please enter a search query above to find songs.</p>";
        $searchQuery = ''; 
    }

    $xml = simplexml_load_file('ex6_xml.xml') or die("<p>Error: Cannot load the XML file.</p>");

    $matchingSongs = [];

    foreach ($xml->song as $song) {
        $name = $song->name ?? 'Unknown Name';
        $details = $song->detail ?? 'No details available';
        $link = $song->link ?? '#';

        if (stripos($name, $searchQuery) !== false || stripos($song->artist, $searchQuery) !== false) {
            $matchingSongs[] = [
                'name' => $name,
                'details' => $details,
                'link' => $link,
            ];
        }
    }

    if (count($matchingSongs) > 0) {
        echo "<p>Found " . count($matchingSongs) . " result(s) for '<strong>" . htmlspecialchars($searchQuery) . "</strong>':</p>";
        foreach ($matchingSongs as $song) {
            echo '<div class="song-result">';
            echo '<p class="song-name"><a href="' . htmlspecialchars($song['link']) . '" target="_blank"><strong>' . htmlspecialchars($song['name']) . '</strong></a></p>';
            echo '<p class="song-details">' . htmlspecialchars($song['details']) . '</p>';
            echo '</div>';
        }
    } else if (!empty($searchQuery)) {
        echo '<p>No results found for "<strong>' . htmlspecialchars($searchQuery) . '</strong>".</p>';
    }
?>
