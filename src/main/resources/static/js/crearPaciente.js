window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const form = document.forms[0];
    
    const urlPaciente = '/v1/paciente';
    const name = document.getElementById('inputNombre');
    const lastName = document.getElementById('inputApellido');
    const dni = document.getElementById('inputDni');
    

    const calle = document.getElementById('inputCalle');
    const numero = document.getElementById('inputNumero');
    const localidad = document.getElementById('inputLocalidad');
    const provincia = document.getElementById('inputProvincia');
    /* -------------------------------------------------------------------------- */
    /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
    /* -------------------------------------------------------------------------- */
    form.addEventListener('submit', function (event) {

        event.preventDefault();
        mostrarSpinner()

        let bodyDomicilio= {
            calle: calle.value,
            numero: numero.value,
            localidad: localidad.value,
            provincia: provincia.value
        }


        let bodyPaciente= {
            nombre: name.value,
            apellido: lastName.value,
            dni: dni.value,
            domicilio: bodyDomicilio
        }

        let settings = {
            method: 'POST',
            body: JSON.stringify(bodyPaciente),
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

        fetch(`${urlPaciente}`, settings)

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
                console.log(`Se creo un Paciente`)
                location.replace('./');
            }
        })

        .catch(error =>{
            ocultarSpinner() 
            console.log(`Promesa rechazada:`);
            console.error(error)
        })

    };
});