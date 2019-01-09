cd tmp/

while read repoURL
do
	echo $repoURL
done < tmp_repositoryURL.txt

while read repoName
do
	echo $repoName
done < tmp_repositoryName.txt

cd ..
cd projects/
mkdir $repoName
cd $repoName

git init
git remote add origin $repoURL
git pull origin master
cd ..
echo setup sucessful
echo please press[ENTER]key
read
