//import static org.easymock.EasyMock.createMock;
//import static org.easymock.EasyMock.expectLastCall;
//import static org.easymock.EasyMock.replay;
//
//import org.easymock.EasyMock;
//import org.junit.Test;
//import org.powermock.reflect.Whitebox;
//
//import br.com.posruy.demo.business.UsuarioRN;
//import br.com.posruy.demo.domain.Usuario;
//import br.com.posruy.demo.persistence.UsuarioDAO;
//
//public class UsuarioRNTest {
//
//    @Test
//    public void insert() {
//	Usuario usuario;
//	UsuarioRN rn = new UsuarioRN();
//
//	UsuarioDAO dao = createMock(UsuarioDAO.class);
//	Whitebox.setInternalState(rn, UsuarioDAO.class, dao);
//
//	dao.inserir(EasyMock.anyObject(Usuario.class));
//	expectLastCall();
//	replay(dao);
//
//	usuario = new Usuario();
//	usuario.setNome("José");
//	usuario.setAnoNascimento(1000);
//	rn.inserir(usuario);
//    }
//
// }
