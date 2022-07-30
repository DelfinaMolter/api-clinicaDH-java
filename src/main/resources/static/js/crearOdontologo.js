window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const url = '/v1/odontologo'
    const form = document.forms[0];
    const name = document.getElementById('inputNombre');
    const lastName = document.getElementById('inputApellido');
    const matricula = document.getElementById('inputMatricula');
    
    /* -------------------------------------------------------------------------- */
    /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
    /* -------------------------------------------------------------------------- */
    form.addEventListener('submit', function (event) {

        event.preventDefault();
        mostrarSpinner()

        let body= {
            nombre: name.value,
            apellido: lastName.value,
            matricula: matricula.value
        }

        let settings = {
            method: 'POST',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        };

        realizarRegister(settings);

        form.reset();

    });

    /* -------------------------------------------------------------------------- */
    /*                    FUNCIÓN 2: Realizar el signup [POST]                    */
    /* -------------------------------------------------------------------------- */
    function realizarRegister(settings) {

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
            if(data == 'CREATED'){
                console.log(`Se creo el Odontologo`)
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