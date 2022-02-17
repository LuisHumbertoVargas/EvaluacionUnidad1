

const API_URL = "http://localhost:8080/";

window.onload = function () {
    if (document.getElementById("listPhotos") !== null) {
        showPhotos();
    } else if (document.getElementById("add") !== null) {
        const formA = document.getElementById('form');
        formA.addEventListener("submit", (e) => {
            e.preventDefault();
            sendFormAdd();
        });
    }


};

function showPhotos() {
    const HTMLResponse = document.querySelector('#table-photos');

    fetch(`${API_URL}/photosAU`)
            .then((response) => response.json())
            .then((photos) => {
                photos.forEach((photo) => {

                    let elementTr = document.createElement('tr');
                    let elementTd1 = document.createElement('td');
                    let elementTd2 = document.createElement('td');
                    let elementTd3 = document.createElement('td');
                    let elementTd4 = document.createElement('td');
                    let elementTd5 = document.createElement('td');
                    let elementTd6 = document.createElement('td');

                    elementTd1.innerHTML = `${photo.id}`;
                    elementTd2.innerHTML = `${photo.title}`;
                    elementTd3.innerHTML = `${photo.url}`;
                    elementTd4.innerHTML = `${photo.status}`;
                    elementTd5.innerHTML = `${photo.lastTime}`;
                    elementTd6.innerHTML = `<a href="/AU/photosAU/edit/${photo.id}">Editar</a>
                                            <a href="/AU/photosAU/delete/${photo.id}">Borrar</a>`;

                    elementTr.appendChild(elementTd1);
                    elementTr.appendChild(elementTd2);
                    elementTr.appendChild(elementTd3);
                    elementTr.appendChild(elementTd4);
                    elementTr.appendChild(elementTd5);
                    elementTr.appendChild(elementTd6);

                    HTMLResponse.appendChild(elementTr);

                });
            });
}

function sendFormAdd() {
    let photo = document.getElementById('uploadInput').value;
    let titlePhoto = document.getElementById('nombreInput').value;

    const params = {
        photo: photo,
        title: titlePhoto
    };

    const options = {
        method = 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(params)
    };

    fetch(`${API_URL}/photosAU`, options)
            .then((response) => response.json())
            .then((response) => {
                if (response !== null) {
                    alert('Save Correctly');
                    console.log(response);
                } else {
                    console.log(response);
                    throw new Error('We have problem Houston!');
                }
            })
            .catch((exception) => {
                console.log(exception);
            }); 
}




