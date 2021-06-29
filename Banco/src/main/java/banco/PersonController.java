package banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import banco.model.Person;
import banco.service.GeneroService;
import banco.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
	private GeneroService generoService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="generoService")
	public void setGeneroService(GeneroService g){
		this.generoService = g;
	}
	
	@RequestMapping(value="/inicio.html",method = RequestMethod.GET)
	public String inicio(Model model) {
		model.addAttribute("listGeneros", this.generoService.listGeneros());
		model.addAttribute("generoUnico", this.generoService.obtenerGenero(2));
		return "test";
	}
	
	//redirecciona test2
	@RequestMapping(value="/test2.html",method = RequestMethod.GET)
	public String redireccionarTest2(Model model) {
		model.addAttribute("listGeneros", this.generoService.listGeneros());
		return "test2";
	}
	
	@RequestMapping(value = "/generos", method = RequestMethod.GET)
	public String listGeneros(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listGeneros", this.personService.listPersons());
		return "person";
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
	
}