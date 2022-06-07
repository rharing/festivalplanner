cd dist
git init
git add -A
git commit -m 'deploy'
git push -f git@github.com:rharing/festivalplanner.git master:gh-pages
