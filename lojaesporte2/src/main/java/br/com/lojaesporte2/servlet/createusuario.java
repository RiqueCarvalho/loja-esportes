package br.com.lojaesporte2.servlet;

import br.com.lojaesporte2.dao.cadastradodao;
import br.com.lojaesporte2.model.usuario;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("cadastra-usuario")
public class createusuario  extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String cpfexiste = request.getParameter("cpf");
        String emailexiste = request.getParameter("email");


         cadastradodao verifica = new cadastradodao();

         if(verifica.verificacpf(cpfexiste)){
             request.setAttribute("ExisteCpf","ja esxite um cadastrdo com este Cpf");
             request.getRequestDispatcher("cadastrodeusuario.jsp").forward(request,response);
         }else if(verifica.verificacpf(cpfexiste)){
             request.setAttribute("Existe email","ja existe um ususario com este email");
             request.getRequestDispatcher("cadastrodeusuario.jsp").forward(request,response);
         }else{
             String nome =request.getParameter("nome");
             String cpf = request.getParameter("cpf");
             String email = request.getParameter("email");
             String senha = request.getParameter("senha");
             String grupo = request.getParameter("grupo");

             usuario usuario = new usuario();
             usuario.setGrupo(nome);
             usuario.setCpf(cpf);
             usuario.setEmail(email);
             usuario.setSenha(senha);
             usuario.setGrupo(grupo);

             cadastradodao cadastradodao = new cadastradodao();
             cadastradodao.cerateusuario(usuario);

             response.sendRedirect("cadastrodeusuario.jsp");





         }



    }


}
