package com.tsf.PlayerRestApi.Controller;

        import com.tsf.PlayerRestApi.Model.Player;
        import com.tsf.PlayerRestApi.Repository.PlayerRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;
        import java.util.List;
        import static java.lang.Integer.parseInt;

@RestController
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;

    //CRUD OPERATIONS

    //CREATE
    @RequestMapping(method = RequestMethod.POST, value = "/addPlayer")
    public String fun1(@RequestBody Player player){
        try{
            playerRepository.save(player);
            return "Record for " + player.getName() + " is inserted!";
        }
        catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    //RETRIEVE
    @RequestMapping(value = "/getAllPlayers", method = RequestMethod.GET, produces = {"application/json"})
    public List<Player> fun2(){
        return playerRepository.findAll();
    }
        
    //UPDATE
    @RequestMapping(method = RequestMethod.PUT, value = "/updatePlayer")
    public String fun4(@RequestParam(name = "id") Long playerID, @RequestParam(name = "name", defaultValue = "false") String newName,
                       @RequestParam(name = "team", defaultValue = "false") String newTeam, @RequestParam(name = "score", defaultValue = "false") String newScore){
        try{
            Player player = playerRepository.getOne(playerID);
            if(newName.compareTo("false")!=0) player.setName(newName);
            if(newTeam.compareTo("false")!=0) player.setTeam(newTeam);
            if(newScore.compareTo("false")!=0) player.setScore(parseInt(newScore));
            playerRepository.save(player);
            return "Record of player with ID " + playerID + " updated!";
        }
        catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/deletePlayer")
    public String fun5(@RequestParam(name = "id") Long playerID){
        try{
            Player player = playerRepository.getOne(playerID);
            playerRepository.delete(player);
            return "Record for " + player.getName() + " deleted!";
        }
        catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
