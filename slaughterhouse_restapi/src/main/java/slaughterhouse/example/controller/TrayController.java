package slaughterhouse.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import slaughterhouse.example.model.Part;
import slaughterhouse.example.model.Tray;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TrayController {
    private final Map<Long, Tray> trays = new HashMap<>();

    @GetMapping
    public Collection<Tray> getAllTrays() {
        return trays.values();
    }

    @PostMapping
    public Tray addTray(@RequestBody Tray tray) {
        trays.put(tray.getId(), tray);
        return tray;
    }

    @GetMapping("/{id}")
    public Tray getTray(@PathVariable Long id) {
        return trays.get(id);
    }

    @PostMapping("/{trayId}/add-animal-part")
    public Tray addAnimalPartToTray(@PathVariable Long trayId, @RequestBody Part animalPart) {
        Tray tray = trays.get(trayId);
        if (tray != null) {
            tray.addAnimalPart(animalPart);
            trays.put(trayId, tray);
        }
        return tray;
    }
}
