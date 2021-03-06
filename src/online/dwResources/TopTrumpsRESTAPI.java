package online.dwResources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import online.configuration.TopTrumpsJSONConfiguration;
import server.GameServer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Path("/toptrumps") // Resources specified here should be hosted at http://localhost:7777/toptrumps
@Produces(MediaType.APPLICATION_JSON) // This resource returns JSON content
@Consumes(MediaType.APPLICATION_JSON) // This resource can take JSON content as input
/**
 * This is a Dropwizard Resource that specifies what to provide when a user
 * requests a particular URL. In this case, the URLs are associated to the
 * different REST API methods that you will need to expose the game commands
 * to the Web page.
 * 
 * Below are provided some sample methods that illustrate how to create
 * REST API methods in Dropwizard. You will need to replace these with
 * methods that allow a TopTrumps game to be controled from a Web page.
 */
public class TopTrumpsRESTAPI {

	/** A Jackson Object writer. It allows us to turn Java objects
	 * into JSON strings easily. */
	ObjectWriter oWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	GameServer gameServer;
	/**
	 * Contructor method for the REST API. This is called first. It provides
	 * a TopTrumpsJSONConfiguration from which you can get the location of
	 * the deck file and the number of AI players.
	 * @param conf
	 */
	public TopTrumpsRESTAPI(TopTrumpsJSONConfiguration conf) {
		// ----------------------------------------------------
		// Add relevant initalization here
		// ----------------------------------------------------
		gameServer = new GameServer();
		
	}
	
	// ----------------------------------------------------
	// Add relevant API methods here
	// ----------------------------------------------------
	
	
	@GET
	@Path("/helloJSONList")
	/**
	 * Here is an example of a simple REST get request that returns a String.
	 * We also illustrate here how we can convert Java objects to JSON strings.
	 * @return - List of words as JSON
	 * @throws IOException
	 */
	public String helloJSONList() throws IOException {
		
		List<String> listOfWords = new ArrayList<String>();
		listOfWords.add("Hello");
		listOfWords.add("World!");
		
		// We can turn arbatory Java objects directly into JSON strings using
		// Jackson seralization, assuming that the Java objects are not too complex.
		String listAsJSONString = oWriter.writeValueAsString(listOfWords);
		
		return listAsJSONString;
	}
	
	@GET
	@Path("/helloWord")
	/**
	 * Here is an example of how to read parameters provided in an HTML Get request.
	 * @param Word - A word
	 * @return - A String
	 * @throws IOException
	 */
	public String helloWord(@QueryParam("Word") String Word) throws IOException {
		return "Hello "+Word;
	}
	
	@GET
	@Path("/gamestart")
	/**
	 * This method will be called when selectionScreen is loaded
	 */
	public String gameStart() throws IOException{
		
		String gamedataJSONStr = gameServer.gameStart();
		
		return gamedataJSONStr;
	}
	
	@GET
	@Path("/gamestart/categoryselect")
	/**
	 * 
	 */
	public String selectCegory() throws IOException{
		
		String gamedataJSONStr = gameServer.categorySelection();
		
		return gamedataJSONStr;
	}
	
	@GET
	@Path("/gamestart/userCategoryselect")
	// use "/gamestart/userCategoryselect?gategory=speed  
	/**
	 * 
	 */
	public String selectCegory(@QueryParam("gategory") String gategory) throws IOException{
		
		String gamedataJSONStr = gameServer.otherPlayerSelect(gategory);
		
		return gamedataJSONStr;
	}
	
	@GET
	@Path("/gamestart/showresult")
	/**
	 * 
	 */
	public String showResult() throws IOException{
		
		return gameServer.showResult();
	}
	
	@GET
	@Path("/gamestart/newround")
	/**
	 * 
	 */
	public String nextRound() throws IOException{
		
		return gameServer.newRound();
	}
	
	@GET
	@Path("/stat")
	
	public String getStat() throws IOException{
			
			return gameServer.getStatistics();
	}
	
	
	@GET
	@Path("/gamestart/autogame")
	
	public String autoGame() throws IOException{
			
			return gameServer.autoGame();
	}
}
