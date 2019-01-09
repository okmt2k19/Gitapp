pwd $a
echo $a
cd tmp/

while read name
do
        echo $name
done < tmp_name.txt

while read email
do
        echo $email
done < tmp_email.txt
git config --global user.name $name
git config --global user.email $email
echo please press[ENTER]key
read
