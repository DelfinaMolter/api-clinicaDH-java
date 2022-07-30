window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const url = '/v1/turno'
    const urlPaciente = '/v1/paciente'
    const urlOdontologo = '/v1/odontologo'
    const form = document.forms[0];
    const paciente = document.getElementById('paciente');
    const odontologo = document.getElementById('odontologo');
    const turno = document.getElementById('turno');

    obtenerInfoPaciente()
    obtenerInfoOdontologo()

    function obtenerInfoPaciente() {
        fetch(urlPaciente)
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
            renderizarInfoPaciente(data)
        })
        .catch(error => {
            console.log('Promesa rechazada:')
            console.error(error)
        })
    
    };

    function renderizarInfoPaciente(listado) {
        
        for (let e of listado) {
            paciente.innerHTML+= `
                <option value="${e.idPaciente}">${e.idPaciente} - ${e.nombre}</option>
                `
        }
        
    };

    function obtenerInfoOdontologo() {
        fetch(urlOdontologo)
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
            renderizarInfoOdontologo(data)
        })
        .catch(error => {
            console.log('Promesa rechazada:')
            console.error(error)
        })
    
    };

    function renderizarInfoOdontologo(listado) {
        
        for (let e of listado) {
            odontologo.innerHTML+= `
                <option value="${e.idOdontologo}">${e.idOdontologo} - ${e.nombre}</option>
                `
        }
        
    };




    
    /* -------------------------------------------------------------------------- */
    /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
    /* -------------------------------------------------------------------------- */
    form.addEventListener('submit', function (event) {

        event.preventDefault();
        mostrarSpinner()

        let body= {
            paciente: {
                idPaciente:paciente.value
            },
            odontologo: {
                idOdontologo: odontologo.value
            },
            fechaYHora: turno.value

        }
        console.log(body)

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