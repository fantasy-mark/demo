#!/bin/bash
for filename in `ls ob*.gif`
do
    echo -----------------------
    echo $filename
    tmp=`echo ${filename//gif/png}`
    echo "=> ${tmp}"
    #${filename/.gif/.png/}
    convert -resize 40x40 $filename $tmp
done
