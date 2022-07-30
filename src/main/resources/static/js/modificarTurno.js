window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const url = '/v1/turno'
    const urlPaciente = '/v1/paciente'
    const urlOdontologo = '/v1/odontologo'
    const form = document.forms[0];
    const pacienteI = document.getElementById('paciente');
    const odontologoI = document.getElementById('odontologo');
    const turno = document.getElementById('turno');
    

    // Recuperar parametros de la URL
    let queryString = window.location.search;
    let urlParams = new URLSearchParams(queryString);
    let urlParam = urlParams.get('id');
    console.log('El id es : ' + urlParam)


    obtenerTurnoPorID()
    
    /* -------------------------------------------------------------------------- */
    /* -------------------------------------------------------------------------- */
    function obtenerTurnoPorID() {

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
            renderizarTurno(data)
        })
        .catch(error => {
            console.log('Promesa rechazada:')
            console.error(error)
        })
    
    };

    function renderizarTurno(e) {
        odontologoI.innerHTML = `
        <option disabled>Selecciona un Odontologo</option>
        <option selected value="${e.odontologo.idOdontologo}">${e.odontologo.idOdontologo} - ${e.odontologo.nombre}</option>
        `
        let id_Odontologo=e.odontologo.idOdontologo
        console.log("id " + id_Odontologo)
        
        pacienteI.innerHTML = `
        <option disabled>Selecciona un Paciente</option>
        <option selected value="${e.paciente.idPaciente}">${e.paciente.idPaciente} - ${e.paciente.nombre}</option>
        `
        let id_Paciente=e.paciente.idPaciente
        console.log( "id " + id_Paciente)

        turno.value = e.fechaYHora

        obtenerInfoPaciente(id_Paciente)
        obtenerInfoOdontologo(id_Odontologo)
    }


    function obtenerInfoPaciente(id_Paciente) {
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
            renderizarInfoPaciente(data, id_Paciente)
        })
        .catch(error => {
            console.log('Promesa rechazada:')
            console.error(error)
        })
    
    };

    function renderizarInfoPaciente(listado, id_Paciente) {
        
        for (let e of listado) {
            if(e.idPaciente != id_Paciente){
                pacienteI.innerHTML+= `
                    <option value="${e.idPaciente}">${e.idPaciente} - ${e.nombre}</option>
                    `
            }
        }
        
    };

    function obtenerInfoOdontologo(id_Odontologo) {
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
            renderizarInfoOdontologo(data, id_Odontologo)
        })
        .catch(error => {
            console.log('Promesa rechazada:')
            console.error(error)
        })
    
    };

    function renderizarInfoOdontologo(listado, id_Odontologo) {
        
        for (let e of listado) {
            if(e.idOdontologo != id_Odontologo){
                odontologoI.innerHTML+= `
                    <option value="${e.idOdontologo}">${e.idOdontologo} - ${e.nombre}</option>
                    `
            }
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
                idPaciente:pacienteI.value
            },
            odontologo: {
                idOdontologo: odontologoI.value
            },
            fechaYHora: turno.value,
            idTurno: urlParam

        }
        console.log(body)

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
                console.log(`Se modificó el Turno: ${data}`)
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