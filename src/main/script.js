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
                        <strong>仓库名称:</strong> ${repo.name}<br>
                        <strong>描述:</strong> ${repo.description}<br>
                        <strong>星标:</strong> ${repo.stargazers_count}<br>
                        <strong>分支:</strong> ${repo.forks_count}<br>
                        <strong>语言:</strong> ${repo.language}<br>
                        <a href="${repo.html_url}" target="_blank">在GitHub上查看</a>
                    `;
                }
            });
        })
        .catch(error => console.error('获取仓库时出错:', error));
});
