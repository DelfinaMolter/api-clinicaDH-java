window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const url = '/v1/users'
    const form = document.forms[0];
    const email = document.querySelector('#inputEmail');
    const pass = document.querySelector('#inputPassword');



    /* -------------------------------------------------------------------------- */
    /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
    /* -------------------------------------------------------------------------- */
    form.addEventListener('submit', function (event) {

        event.preventDefault();

        mostrarSpinner()

        realizarLogin();

        form.reset();

    });

    /* -------------------------------------------------------------------------- */
    /*                     FUNCIÓN 2: Realizar el login [POST]                    */
    /* -------------------------------------------------------------------------- */
    function realizarLogin() {

        fetch(`${url}/login`)

        .then(response => {
            console.log(response)
            if(!response.ok){
                alert(`Hubo un error, intentelo de nuevo.`)
            }
            return response.json()
        })

        .then(data => {
            console.log(`Promesa cumplida:`);
            console.log(data);

            if(data.jwt){
                console.log(`Guardando el token en localStorage`)

                localStorage.setItem('jwt', JSON.stringify(data.jwt));

                location.replace('./index.html');
            }
        })

        .catch(error => {
            ocultarSpinner() 
            console.log(`Promesa rechazada:`);
            console.error(error)
        })

    };
});