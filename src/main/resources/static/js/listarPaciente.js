

// if (!localStorage.jwt){
//     console.log('No esta logueado');
//     location.replace('/index.html');
// }

  /* ------ comienzan las funcionalidades una vez que carga el documento ------ */
window.addEventListener('load', function () {

    /* ---------------- variables globales y llamado a funciones ---------------- */
    const urlList = '/v1/paciente';
    const listar =  document.querySelector('div.listar');
    const botonListar = document.querySelector('#listar_paciente');
    // const token = JSON.parse(localStorage.jwt);

    botonListar.addEventListener('click', function (event) {
      event.preventDefault()
      obtenerPacinetes()
      listar.classList.remove("hidden");
    })
  
    /* -------------------------------------------------------------------------- */
    /* -------------------------------------------------------------------------- */
  
    function obtenerPacinetes() {
      
      fetch(urlList)
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
        botonBorrar()
      })
      .catch(error => {
        console.log('Promesa rechazada:')
        console.error(error)
      })
  
    };
  
    /* -------------------------------------------------------------------------- */
    /* -------------------------------------------------------------------------- */
    function renderizarPaciente(listado) {
      listar.innerHTML=''
      listar.innerHTML+= `
      <h1> Pacientes </h1>
      <table class="pacinetesData">
          <tr>
            <th>ID</th>
            <th>NOMBRE</th>
            <th>APELIDO</th>
            <th>DNI</th>
            <th>FECHA DE ALTA</th>
            <th>DOMICILIO</th>
            <th>ACCIONES</th>
          </tr>
      </table>`

      
      for (let paciente of listado) {
        let listarPacientes = document.querySelector('.pacinetesData');
        listarPacientes.innerHTML+= `
          <tr class="datos_list">
            <td>${paciente.idPaciente}</td>
            <td>${paciente.nombre}</td>
            <td>${paciente.apellido}</td>
            <td>${paciente.dni}</td>
            <td>${paciente.fechaDeAlta}</td>
            <td>${paciente.domicilio.calle} ${paciente.domicilio.numero}, ${paciente.domicilio.localidad}, ${paciente.domicilio.provincia}</td>
            <td><a href="/modificarPaciente.html?id=${paciente.idPaciente}"><i class="fa-solid fa-pen-to-square"></i></a><i class="fa-solid fa-trash-can borrar" id="${paciente.idPaciente}"></i></td>
          </tr>`
      }
      
    };
  
  
    /* -------------------------------------------------------------------------- */
    /*               Eliminar [DELETE]                    */
    /* -------------------------------------------------------------------------- */
    function botonBorrar() {
      
      let btnBorrar = document.querySelectorAll('.borrar');
  
      btnBorrar.forEach(boton =>{
        boton.addEventListener('click', (e)=>{
          const borrar = confirm('¿Desea borrar el Paciente con id '+e.target.id + '?');
          if(borrar){
            console.log(e)
            let id = e.target.id;
            let url = `${urlList}/${id}`
    
            const settings = {
              method: 'DELETE',
              headers: {
                'Content-Type': 'application/json'
              }
            }
            fetch(url, settings)
            .then(response => {
              console.log('Borrado de Paciente, status:')
              console.log(response.status)
              obtenerPacinetes()
            })
            .catch(error => {
              console.log('Promesa rechazada:')
              console.error(error)
            })
          }
        })
      })
    };
  });