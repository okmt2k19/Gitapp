cd tmp/

while read filenames
do
	echo $filenames
done < tmp_files.txt

while read filepaths
do
	echo $filepaths
done < tmp_filepaths.txt

while read m
do
	echo $m
done < tmp_message.txt

IFS_ORIGINAL="$IFS"
IFS=";"
namesArray=($filenames)
pathArray=($filepaths)
IFS="$IFS_ORIGINAL"

cd ..
cd projects/
home=$(pwd)
echo $home
for((i=0; i<${#namesArray[@]}; i++))
do
	cd $home
	cd ${pathArray[i]}
	git add ${namesArray[i]}
done
git commit -m"$m"
git push origin master

echo pres any key
read

