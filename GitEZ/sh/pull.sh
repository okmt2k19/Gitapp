cd tmp/


while read reponame
do
        echo $reponame
done < selectedrepository.txt

cd ..
cd projects/

cd $reponame

git pull origin master

echo press any key 

read

