

// if (!localStorage.jwt){
//     console.log('No esta logueado');
//     location.replace('/index.html');
// }

  /* ------ comienzan las funcionalidades una vez que carga el documento ------ */
window.addEventListener('load', function () {

    /* ---------------- variables globales y llamado a funciones ---------------- */
    const urlList = '/v1/odontologo';
    const listar =  document.querySelector('div.listar');
    const botonListar = document.querySelector('#listar_odontologo');
    // const token = JSON.parse(localStorage.jwt);

    botonListar.addEventListener('click', function (event) {
      event.preventDefault()
      obtenerOdontologos()
      listar.classList.remove("hidden");
    })
  
    /* -------------------------------------------------------------------------- */
    /* -------------------------------------------------------------------------- */
  
    function obtenerOdontologos() {
      
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
        renderizarOdontologos(data)
        botonBorrar()
      })
      .catch(error => {
        console.log('Promesa rechazada:')
        console.error(error)
      })
  
    };
  
    /* -------------------------------------------------------------------------- */
    /* -------------------------------------------------------------------------- */
    function renderizarOdontologos(listado) {
      listar.innerHTML=''
      listar.innerHTML+= `
      <h1> Odontologos </h1>
      <table class="odontologosData">
          <tr>
            <th>ID</th>
            <th>NOMBRE</th>
            <th>APELIDO</th>
            <th>MATRICULA</th>
            <th>ACCIONES</th>
          </tr>
      </table>`

      
      for (let odontologo of listado) {
        let listarOdontologos = document.querySelector('.odontologosData');
        listarOdontologos.innerHTML+= `
          <tr class="datos_list">
            <td>${odontologo.idOdontologo}</td>
            <td>${odontologo.nombre}</td>
            <td>${odontologo.apellido}</td>
            <td>${odontologo.matricula}</td>
            <td><a href="/modificarOdontologo.html?id=${odontologo.idOdontologo}"><i class="fa-solid fa-pen-to-square"></i></a><i class="fa-solid fa-trash-can borrar" id="${odontologo.idOdontologo}"></i></td>
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
          const borrar = confirm('¿Desea borrar el Odontologo con id '+e.target.id + '?');
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
              console.log('Borrado de Odontologo, status:')
              console.log(response.status)
              obtenerOdontologos()
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