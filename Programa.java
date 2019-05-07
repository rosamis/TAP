import model.Grupo;
import model.Mensagem;
import model.Usuario;

import java.util.Arrays;

public class Programa {

    public static void main(String[] args) {

        //Criando pessoas: p1, p2, p3, p4
        Usuario p1 = Factory.criaUsuario("p1","998400541","So queria café!","ro.jpg");
        Usuario p2 = Factory.criaUsuario("p2","999999999","Qual o nome daquela mulher? A dama da noite da boate azul!!","enzo.jpg");
        Usuario p3 = Factory.criaUsuario("p3","998400505",":)","enza.jpeg");
        Usuario p4 = Factory.criaUsuario("p4","988442001","Amo minhas turmas de TAP e ALG3 <3","didonet.png");

        //  p1 cria o grupo g1;
        Grupo g1 = Factory.criaGrupo("g1", p1,"Grupo de TAP");

        //Adicionando ao grupo
        g1.register(p2);
        g1.register(p3);
        g1.register(p4);

        //Registrando no grupo
        p1.setSubject(g1);
        p2.setSubject(g1);
        p3.setSubject(g1);
        p4.setSubject(g1);

        // p1 cria o grupo g2;
        Grupo g2 = Factory.criaGrupo("g2", p1," Grupo dos roles");

        //Adicionando ao grupo
        g2.register(p2);
        g2.register(p3);

        //Registrando no grupo
        p1.setSubject(g2);
        p2.setSubject(g2);
        p3.setSubject(g2);

        // p3 cria o grupo g3;
        Grupo g3 = Factory.criaGrupo("g3", p3,"É o amor!!");

        //Adicionando ao grupo
        g3.register(p4);

        //Registrando no grupo
        p3.setSubject(g3);
        p4.setSubject(g3);

        // p2 envia mensagem para g1; (todos visualizam)
        Mensagem msg1 = Factory.criaMensagem("'Ola, gente! O que vai cair na prova? '",p2);

        EnviaCommand envia = new EnviaCommand(g1,msg1);
        envia.executa();

        LeCommand le = new LeCommand(g1,Arrays.asList(p1,p2,p3,p4));
        le.executa();

        // p1 envia mensagem para g1; (todos visualizam)
        Mensagem msg2 = Factory.criaMensagem("'Lágrimas.. haha'",p1);

        EnviaCommand envia2 = new EnviaCommand(g1,msg2);
        envia2.executa();

        LeCommand le2 = new LeCommand(g1,Arrays.asList(p1,p2,p3,p4));
        le2.executa();

        // p2 envia mensagem para g2; (todos menos p3 visualizam)
        Mensagem msg3 = Factory.criaMensagem("'E ai, qual a boa pra hoje?'",p2);

        EnviaCommand envia3 = new EnviaCommand(g2,msg3);
        envia3.executa();

        LeCommand le3 = new LeCommand(g2,Arrays.asList(p1,p2));
        le3.executa();

        // p3 envia mensagem para g3;
        Mensagem msg4 = Factory.criaMensagem("'Como faz a questão 7 da lista 1?'",p3);

        EnviaCommand envia4 = new EnviaCommand(g3,msg4);
        envia4.executa();

        LeCommand le4 = new LeCommand(g3,Arrays.asList());
        le4.executa();

        // p3 envia mensagem para g2; (p2 e p1 visualizam)
        Mensagem msg5 = Factory.criaMensagem("'Bora James?'",p3);

        EnviaCommand envia5 = new EnviaCommand(g2,msg5);
        envia5.executa();

        LeCommand le5 = new LeCommand(g2,Arrays.asList(p1,p2));
        le5.executa();

        // p3 cancela mensagem para g3)
        ExcluiCommand cancela1 = new ExcluiCommand(g3,msg4,p3);
        cancela1.executa();

        // p3 envia mensagem para g3; (todos visualizam)
        Mensagem msg6 = Factory.criaMensagem("'Bom dia'",p3);

        EnviaCommand envia6 = new EnviaCommand(g3,msg6);
        envia6.executa();

        LeCommand le6 = new LeCommand(g3,Arrays.asList(p4));
        le6.executa();

    }
}