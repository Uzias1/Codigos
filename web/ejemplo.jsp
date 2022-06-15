<%-- 
    Document   : ejemplo
    Created on : 11/06/2022, 01:45:28 PM
    Author     : Uz�as
--%>

<jsp:include page="parciales/header.jsp" />

<div class="container-fluid">
    <div class="row">
        <div class="col"><h1>C�digos</h1></div>
    </div>
    <div class="row">
        <div class="col">Un m�todo de codificaci�n eficaz, es si se usa una matriz invertible de gran tama�o, como se
describa a continuaci�n. Sea una matriz M invertible, que s�lo conocen quienes la
transmiten y quienes la reciben. </div>
    </div>
    <div class="row">
        <div class="col"><img class="img-fluid" src="img/matriz_ej.png"> </div>
    </div>
    <div class="row">
        <div class="col">Sup�ngase que se desea codificar el mensaje:
            ATTACK NOW. Se reemplaza cada letra con el n�mero que le corresponde a su posici�n en el alfabeto. Un espacio se representa por 0</div>
    </div>
    <div class="row">
        <div class="col"><img class="img-fluid" src="img/attack.png"> </div>
    </div>
    <div class="row">
        <div class="col">Y multiplicamos por la izquierda a M:</div>
    </div>
    <div class="row"><div class="col"><img class="img-fluid" src="img/midej.png"> </div></div> 
    <div class="row">
        <div class="col">Con lo que se obtiene la sucesi�n de n�meros 77, 39, -56, -18, 35, 19, 56, 28, 47, 31. �ste es el
            mensaje cifrado. Para decodificarlo, quien lo recibe necesita calcular M<sup>-1</sup> 
</div>
    </div>
    <div class="row"><div class="col"><img class="img-fluid" src="img/finej.png"> </div></div>
</div>

<jsp:include page="parciales/footer.jsp" />