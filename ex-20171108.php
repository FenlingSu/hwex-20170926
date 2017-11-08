<?php
/**
 * Created by PhpStorm.
 * User: USER
 * Date: 2017/11/8
 * Time: 上午 10:05
 */
$i;
$j;
$m = 6;
$n = 6;
$r = $_POST['r'];
$g = $_POST['g'];
$b = $_POST['b'];
$a = $_POST['a'];

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>
<body>

<h3 style="background-color: rgb(<?php echo $r.','.$g.','.$b ?>);">
        <?php
        echo "<table border='1em'>";
            for( $i=1; $i<=$m; $i++) {
               echo "<tr>";
                for ($j = 1; $j<=$n; $j++)
                    echo "<td align='center' width='30em'>" . $i * $j . "</td>";
                "</tr>";
            }
            "</table>";
        ?>
</h3>



</body>
</html>
