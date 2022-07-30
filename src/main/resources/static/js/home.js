window.addEventListener('load', function () {

    const btnCerrarSesion =  document.querySelector('#closeApp');

    /* -------------------------------------------------------------------------- */
    /*                          FUNCIÓN 1 - Cerrar sesión                         */
    /* -------------------------------------------------------------------------- */

    btnCerrarSesion.addEventListener('click', function () {
        const logout = confirm('¿Desea cerrar sesión?');
        if(logout){
            localStorage.clear();
            location.replace('/logout');
            location.replace('/login');
        }
    });
})