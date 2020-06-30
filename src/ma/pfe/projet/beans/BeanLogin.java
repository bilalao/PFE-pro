package ma.pfe.projet.beans;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.stereotype.Component;

@ManagedBean
@Component
public class  BeanLogin {
    
    private String username;
     
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login() throws IOException{
    	
        FacesMessage message = null;
        boolean loggedIn = false;
   
        if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        
          
           
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Username ou mot de passe incorrect", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
    }  
    public void doLogout() throws IOException {
    	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    	 FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    }
}