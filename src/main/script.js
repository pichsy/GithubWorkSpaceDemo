document.addEventListener('DOMContentLoaded', function() {
    const repoList = document.getElementById('repo-list');
    const xwidgetSection = document.getElementById('xwidget').querySelector('p');

    fetch('https://api.github.com/users/pichsy/repos')
        .then(response => response.json())
        .then(repos => {
            repos.forEach(repo => {
                const listItem = document.createElement('li');
                listItem.textContent = repo.name;
                repoList.appendChild(listItem);

                if (repo.name === 'xwidget') {
                    xwidgetSection.textContent = `Repository Name: ${repo.name}
                    Description: ${repo.description}
                    Stars: ${repo.stargazers_count}
                    Forks: ${repo.forks_count}
                    Language: ${repo.language}`;
                }
            });
        })
        .catch(error => console.error('Error fetching repositories:', error));
});
