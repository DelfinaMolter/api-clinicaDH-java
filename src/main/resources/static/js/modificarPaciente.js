window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const url = '/v1/paciente'
    const form = document.forms[0];
    const name = document.getElementById('inputNombre');
    const lastName = document.getElementById('inputApellido');
    const dni = document.getElementById('inputDni');

    const calle = document.getElementById('inputCalle');
    const numero = document.getElementById('inputNumero');
    const localidad = document.getElementById('inputLocalidad');
    const provincia = document.getElementById('inputProvincia');

    // Recuperar parametros de la URL
    let queryString = window.location.search;
    let urlParams = new URLSearchParams(queryString);
    let urlParam = urlParams.get('id');
    console.log('El id es : ' + urlParam)
    let idDom;


    obtenerPacientePorID()

    /* -------------------------------------------------------------------------- */
    /* -------------------------------------------------------------------------- */
    function obtenerPacientePorID() {

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
            renderizarPaciente(data)
        })
        .catch(error => {
            console.log('Promesa rechazada:')
            console.error(error)
        })
    
    };

    function renderizarPaciente(paciente) {
        name.value = paciente.nombre
        lastName.value = paciente.apellido
        dni.value = paciente.dni
        calle.value = paciente.domicilio.calle
        numero.value = paciente.domicilio.numero
        localidad.value = paciente.domicilio.localidad
        provincia.value = paciente.domicilio.provincia
        idDom = paciente.domicilio.idDomicilio
    }
    /* -------------------------------------------------------------------------- */
    /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
    /* -------------------------------------------------------------------------- */
    form.addEventListener('submit', function (event) {
        console.log(idDom)
        event.preventDefault();
        mostrarSpinner()

        let bodyDomicilio= {
            calle: calle.value,
            numero: numero.value,
            localidad: localidad.value,
            provincia: provincia.value,
            idDomicilio: idDom
        }


        let bodyPaciente= {
            nombre: name.value,
            apellido: lastName.value,
            dni: dni.value,
            domicilio: bodyDomicilio,
            idPaciente: urlParam
        }

        console.log(bodyPaciente)

        let settings = {
            method: 'PUT',
            body: JSON.stringify(bodyPaciente),
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
                console.log(`Se modificó el Paciente: ${data}`)
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