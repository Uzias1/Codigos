<%-- 
    Document   : succes
    Created on : 14/06/2022, 07:30:15 PM
    Author     : Uzías
--%>
<jsp:include page="parciales/header.jsp" />

<div class="container-fluid" id="container">
    <div class="row">
        <div class="col">
            <h1>Exito</h1>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <h2>Los resultados son los siguientes:</h2>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="card border-success mb-3" style="max-width: 20rem;" id="xd">
                <div class="card-header">La matriz inversa es:</div>
                <div class="card-body">
                    <% 
                        HttpSession sesion = request.getSession();
                        int [][] matriz = (int[][])sesion.getAttribute("matriz");
                        for(int i = 0; i<3; i++){
                            for (int j = 0; j < 3; j++) {
                                    int aux = matriz[i][j];
                                
                    %>
                        <%=aux%>
                    <%
                        }
                        %>
                        <br>
                    <%
                    }
                    %>
                </div>
            </div>
            <div class="card border-success mb-3" style="max-width: 20rem;" id="xd">
                <div class="card-header">El mensaje descifrado es:</div>
                <div class="card-body">
                    <%
                       String s = (String)sesion.getAttribute("mensaje");
                    %>
                    <%= s%> 
                </div>
            </div>
        </div>
        <div class="col-md-3" id="rata">
                <video src="multimedia/dorime.mp4"  width="300" height="400" controls="controls"></video>
        </div>
    </div>
</div>

<jsp:include page="parciales/footer.jsp" />
