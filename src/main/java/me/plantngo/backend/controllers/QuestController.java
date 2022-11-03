package me.plantngo.backend.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.plantngo.backend.DTO.QuestDTO;
import me.plantngo.backend.models.Quest;
import me.plantngo.backend.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Quest Controller", description = "CRUD operations for quests")
@RequestMapping("api/v1/quests")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestController {
    private final QuestService questService;

    @Autowired
    public QuestController (QuestService questService) {
        this.questService = questService;
    }

    @ApiOperation(value = "Get all quests")
    @GetMapping(path="")
    public List<Quest> getAllQuests() {return questService.getAllQuests();}

    @ApiOperation(value = "Get a specific quest by id")
    @GetMapping(path="/{id}")
    public Quest getQuest(@PathVariable Integer id) {return questService.getQuest(id);}

    @ApiOperation(value = "Get active quests")
    @GetMapping(path="/active")
    public List<Quest> getActiveQuests() {return questService.getActiveQuests();}

    @ApiOperation(value = "Get inactive quests")
    @GetMapping(path="/inactive")
    public List<Quest> getInactiveQuests() {return questService.getInactiveQuests();}

    @ApiOperation(value = "Create a new quest")
    @PostMapping(path = "")
    public ResponseEntity<String> addQuest(@Valid @RequestBody QuestDTO questDTO) {return questService.addQuest(questDTO);}

    @ApiOperation(value = "Delete a quest by id")
    @DeleteMapping (path="/{id}")
    public ResponseEntity<String> deleteQuest(@PathVariable Integer id) {return questService.deleteQuest(id);}

    @ApiOperation("Refresh a single quest")
    @PostMapping("/{id}/refresh")
    public ResponseEntity<String> refreshQuest(@PathVariable Integer id) {return questService.refreshQuest(id);}

    @ApiOperation("Refresh all quests")
    @PostMapping("/refresh")
    public ResponseEntity<String> refreshAll() {return questService.refreshAll();}

}
