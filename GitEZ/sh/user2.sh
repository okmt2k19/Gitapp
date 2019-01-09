cd tmp/

while read name
do
        echo $name
done < tmp_name.txt

while read email
do
	echo $email
done < tmp_email.txt

cd tmp/

while read name
do
        echo $name
done < tmp_name.txt

while read email
do
        echo $email
done < tmp_email.txt
git config --global user.name $name --replace-all
git config --global user.email $email --replace-all
git commit --amend 
echo please press[ENTER]key
read
