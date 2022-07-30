window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const url = '/v1/odontologo'
    const form = document.forms[0];
    const name = document.getElementById('inputNombre');
    const lastName = document.getElementById('inputApellido');
    const matricula = document.getElementById('inputMatricula');
    

    // Recuperar parametros de la URL
    let queryString = window.location.search;
    let urlParams = new URLSearchParams(queryString);
    let urlParam = urlParams.get('id');
    console.log('El id es : ' + urlParam)


    obtenerOdontologoPorID()

    /* -------------------------------------------------------------------------- */
    /* -------------------------------------------------------------------------- */
    function obtenerOdontologoPorID() {

        fetch(`${url}/${urlParam}`)
        .then(response => {
            console.log(response)
            if(!response.ok){
                alert(`Hubo un error, intentelo de nuevo.`)
            }
            return response.json();
            })
        .then(data => {
            console.log('Promesa cumplida:')
            console.log(data)
            renderizarOdontologo(data)
        })
        .catch(error => {
            console.log('Promesa rechazada:')
            console.error(error)
        })
    
    };

    function renderizarOdontologo(odontologo) {
        name.value = odontologo.nombre
        lastName.value = odontologo.apellido
        matricula.value = odontologo.matricula
    }
    /* -------------------------------------------------------------------------- */
    /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
    /* -------------------------------------------------------------------------- */
    form.addEventListener('submit', function (event) {

        event.preventDefault();
        mostrarSpinner()

        let body= {
            nombre: name.value,
            apellido: lastName.value,
            matricula: matricula.value,
            idOdontologo: urlParam
        }

        let settings = {
            method: 'PUT',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        };

        realizarModificacion(settings);

        form.reset();

    });

    /* -------------------------------------------------------------------------- */
    /* -------------------------------------------------------------------------- */
    function realizarModificacion(settings) {

        fetch(`${url}`, settings)

        .then(response => {
            console.log(response)
            if(!response.ok){
                alert(`Hubo un error, intentelo de nuevo.`)
            }
            return response.json();
        })

        .then(data => {
            console.log(`Promesa cumplida:`);
            console.log(data);
            if(data == 'OK'){
                console.log(`Se modificó el Odontologo: ${data}`)
                location.replace('./');
            }
        })

        .catch(erro =>{
            ocultarSpinner() 
            console.log(`Promesa rechazada:`);
            console.error(erro)
        })

    };
});