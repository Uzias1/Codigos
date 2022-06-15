<%-- 
    Document   : problema1
    Created on : 11/06/2022, 03:38:01 PM
    Author     : Uzías
--%>

<jsp:include page="parciales/header.jsp" />

<div class="container-fluid" id="container">
    <div class="row">
        <div class="col">
            <h1>Problema 1</h1>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <img class="img-fluid" src="img/pro1.png">
        </div>
        <!--
        <div class="col-md-3">
            <video src="multimedia/dorime.mp4"  width="300" height="400" controls="controls"></video>
        </div>
        -->
    </div>
    <div class="row">
        <div class="col">
            Tomando en cuenta lo mencionado en el ejemplo, lo primero que debe hacerse es calcular la matriz inversa de la que nos dan.
        </div>
    </div>
    <!-- 
    AQUI EMPIEZA EL FORMULARIO PARA LA MATRIZ Y EL CONJUNTO DE NUMEROS
    -->
    <form action="Invierte" method="post">
    <div class="row">
        <div class="col-md-3">Ingresa la matriz de 3x3 original (A)</div>
        <div class="col-md-7" id="carta">
            <div class="card border-primary mb-3" style="max-width: 20rem;">
                <div class="card-header">Matriz 3x3</div>
                <div class="card-body">
                    <input type="number" class="form-control"   name="m11" required>
                    <input type="number" class="form-control"   name="m12" required>
                    <input type="number" class="form-control"   name="m13" required>
                </div>
                <div class="card-body">
                    <input type="number" class="form-control"   name="m21" required>
                    <input type="number" class="form-control"   name="m22" required>
                    <input type="number" class="form-control"   name="m23" required>
                </div>
                <div class="card-body">
                    <input type="number" class="form-control"   name="m31" required>
                    <input type="number" class="form-control"   name="m32" required>
                    <input type="number" class="form-control"   name="m33" required>
                </div>
            </div>
            
        </div>
    </div>
    <div class="row">
        <div class="col">
            Una vez obtenida la inversa, se multiplicará por el conjunto de vectores que se nos dan
        </div>
    </div> 
    <div class="row">
        <div class="col-md-3">Ingresa el conjunto de numeros a descifrar (maximo 30), llena los espacios sobrantes con "0"</div>
        <div class="col-md-7" id="carta">
            <div class="card border-success mb-3" >
                <div class="card-header">Valores</div>
                <div class="card-body">
                    <input type="number" class="form-control"   name="d1" required>
                    <input type="number" class="form-control"   name="d2" required>
                    <input type="number" class="form-control"   name="d3" required>
                    <input type="number" class="form-control"   name="d4" required>
                    <input type="number" class="form-control"   name="d5" required>
                </div>
                <div class="card-body">
                    <input type="number" class="form-control"   name="d6" required>
                    <input type="number" class="form-control"   name="d7" required>
                    <input type="number" class="form-control"   name="d8" required>
                    <input type="number" class="form-control"   name="d9" required>
                    <input type="number" class="form-control"   name="d10" required>
                </div>
                <div class="card-body">
                    <input type="number" class="form-control"   name="d11" required>
                    <input type="number" class="form-control"   name="d12" required>
                    <input type="number" class="form-control"   name="d13" required>
                    <input type="number" class="form-control"   name="d14" required>
                    <input type="number" class="form-control"   name="d15" required>
                </div>
                <div class="card-body">
                    <input type="number" class="form-control"   name="d16" required>
                    <input type="number" class="form-control"   name="d17" required>
                    <input type="number" class="form-control"   name="d18" required>
                    <input type="number" class="form-control"   name="d19" required>
                    <input type="number" class="form-control"   name="d20" required>
                </div>
                <div class="card-body">
                    <input type="number" class="form-control"   name="d21" required>
                    <input type="number" class="form-control"   name="d22" required>
                    <input type="number" class="form-control"   name="d23" required>
                    <input type="number" class="form-control"   name="d24" required>
                    <input type="number" class="form-control"   name="d25" required>
                </div>
                <div class="card-body">
                    <input type="number" class="form-control"   name="d26" required>
                    <input type="number" class="form-control"   name="d27" required>
                    <input type="number" class="form-control"   name="d28" required>
                    <input type="number" class="form-control"   name="d29" required>
                    <input type="number" class="form-control"   name="d30" required>
                </div>
            </div>
            
        </div>
    </div>
    <div class="row">
        <div class="col">
            Presiona el botón para obtener el mensaje descifrado
        </div>
        <div class="col">
            <button type="submit" class="btn btn-primary">Calcular</button>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="card border-dark">
                <div class="card-header">Resultados</div>
                <div class="card-body">
                  <p class="card-text">A continuación se muestra la matriz inversa y el mensaje descifrado.</p>
                </div>
            </div>   
        </div>
    </div> 
    </form>
</div>

<jsp:include page="parciales/footer.jsp" />
