

// if (!localStorage.jwt){
//     console.log('No esta logueado');
//     location.replace('/index.html');
// }

  /* ------ comienzan las funcionalidades una vez que carga el documento ------ */
window.addEventListener('load', function () {

    /* ---------------- variables globales y llamado a funciones ---------------- */
    const urlList = '/v1/turno';
    const listar =  document.querySelector('div.listar');
    const botonListar = document.querySelector('#listar_turno');
    // const token = JSON.parse(localStorage.jwt);

    botonListar.addEventListener('click', function (event) {
      event.preventDefault()
      obtenerTurnos()
      listar.classList.remove("hidden");
    })
  
    /* -------------------------------------------------------------------------- */
    /* -------------------------------------------------------------------------- */
  
    function obtenerTurnos() {
      
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
        renderizarTurnos(data)
        botonBorrar()
      })
      .catch(error => {
        console.log('Promesa rechazada:')
        console.error(error)
      })
  
    };
  
    /* -------------------------------------------------------------------------- */
    /* -------------------------------------------------------------------------- */
    function renderizarTurnos(listado) {
      listar.innerHTML=''
      listar.innerHTML+= `
      <h1> Turnos </h1>
      <table class="turnosData">
          <tr>
            <th>ID</th>
            <th>ODONTOLOGO</th>
            <th>PACIENTE</th>
            <th>TURNO</th>
            <th>ACCIONES</th>
          </tr>
      </table>`

      
      for (let turno of listado) {
        let listarturnos = document.querySelector('.turnosData');
        listarturnos.innerHTML+= `
          <tr class="datos_list">
            <td>${turno.idTurno}</td>
            <td>${turno.odontologo.nombre}</td>
            <td>${turno.paciente.nombre}</td>
            <td>${turno.fechaYHora}</td>
            <td><a href="/modificarTurno.html?id=${turno.idTurno}"><i class="fa-solid fa-pen-to-square"></i></a><i class="fa-solid fa-trash-can borrar" id="${turno.idTurno}"></i></td>
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
          const borrar = confirm('¿Desea borrar el turno con el id '+e.target.id + '?');
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
              console.log('Borrado de Turno, status:')
              console.log(response.status)
              obtenerTurnos()
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