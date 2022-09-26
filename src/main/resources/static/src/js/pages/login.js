

async function iniciarSesion(e) {
    e.preventDefault();
    let datos={};
    datos.nombre=document.getElementById('txtNombre').value;
    datos.contrasenia=document.getElementById('txtContrasenia').value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    try {
        const response =await request.json();
        let item=response.persona;
        localStorage.id=response.id;
        localStorage.nombre=response.nombre;
        localStorage.perfil=response.perfil;
        localStorage.persona_id=item.id;
        localStorage.persona_nombre=item.nombre;
        localStorage.persona_apellidoPaterno=item.apellidoPaterno;
        localStorage.persona_apellidoMaterno=item.apellidoMaterno;
        localStorage.persona_dni=item.dni;
        localStorage.persona_sexo=item.sexo;
        localStorage.persona_correo=item.correo;

        window.location.href='/pages/dashboard/dashboard.html';

        // window.open("/pages/dashboard/dashboard.html","_self")


    }catch{
        $('#passwordError').modal('show');
    }

    // if (response!=null){
    // localStorage.token=respuesta;
    // localStorage.email=datos.email;
    // window.location.href='/pages/dashboard/dashboard.html';
    // }else{
    //     alert("Las credenciales no son correctas")
    // }
}



function keyPress(e) {
    if (e.keyCode === 13 && !e.shiftKey) {
        e.preventDefault();
        iniciarSesion();
    }
}