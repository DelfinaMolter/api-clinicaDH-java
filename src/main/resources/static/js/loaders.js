function mostrarSpinner() {
    const body = document.querySelector("body");
    const form = document.querySelector("form");
    
    // Creamos nuestro spinner
    const spinnerContainer = document.createElement("div");
    const spinner = document.createElement("div");
    
    // Asignamos los IDs a cada nuevo elemento, para poder manipular sus estilos
    spinnerContainer.setAttribute("id", "contenedor-carga");
    spinner.setAttribute("id", "carga");
    
    // Ocultamos el formulario de registro
    form.classList.add("hidden");
    
    // Agregamos el Spinner a nuestro HTML.
    spinnerContainer.appendChild(spinner);
    body.appendChild(spinnerContainer);
    
    return;
}


function ocultarSpinner() {
    const body = document.querySelector("body");
    const form = document.querySelector("form");

    // Seleccionamos el spinner
    const spinnerContainer = document.querySelector("#contenedor-carga");

    // Removemos el spinner del HTML
    body.removeChild(spinnerContainer);

    // Quitamos la clase que oculta el formulario
    form.classList.remove("hidden");

    return;
}
