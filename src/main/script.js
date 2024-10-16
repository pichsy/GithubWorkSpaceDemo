document.addEventListener('DOMContentLoaded', function() {
    const repoList = document.getElementById('repo-list');
    const xwidgetSection = document.getElementById('xwidget').querySelector('p');

    fetch('https://api.github.com/users/pichsy/repos')
        .then(response => response.json())
        .then(repos => {
            repos.forEach(repo => {
                const listItem = document.createElement('li');
                listItem.innerHTML = `
                    <h3>${repo.name}</h3>
                    <p>${repo.description}</p>
                    <img src="https://via.placeholder.com/150" alt="${repo.name}">
                `;
                repoList.appendChild(listItem);

                if (repo.name === 'xwidget') {
                    xwidgetSection.innerHTML = `
                        <strong>Repository Name:</strong> ${repo.name}<br>
                        <strong>Description:</strong> ${repo.description}<br>
                        <strong>Stars:</strong> ${repo.stargazers_count}<br>
                        <strong>Forks:</strong> ${repo.forks_count}<br>
                        <strong>Language:</strong> ${repo.language}<br>
                        <a href="${repo.html_url}" target="_blank">View on GitHub</a>
                    `;
                }
            });
        })
        .catch(error => console.error('Error fetching repositories:', error));
});
