# ChairsReloaded

<div align="center">
 <img src="https://user-images.githubusercontent.com/62361708/224350839-5483032d-8053-4797-ae60-fba44476ce73.png" width=256>
</div>

Minecraft plugin that allows admins to create Trading Cards and Map Art that players can collect.

Uses [NexiaAPI](https://github.com/NexiaDevelopers/NexiaAPI) and [ACF](https://github.com/aikar/commands).

Originally developed by [ItsGeppy](https://github.com/Gepsu) and maintained by [HeadMonitor](https://github.com/HeadMonitor) for the [Nexia Network](https://www.playnexia.net/).

<img src="https://user-images.githubusercontent.com/62361708/224358914-2c5eda3f-4843-4edc-8d83-d64247e30ae6.png" width=512>
<img src="https://user-images.githubusercontent.com/62361708/224359015-359ab709-c6f9-49a8-b815-36e8e366c33c.png" width=512>

## Commands

- `/chairs toggle` Toggles the ability to sit on Stairs and Slabs on or off. This is helpful if Players are building with those blocks. 

## Permission Nodes

- `nexia.chairsreloaded.chairs.toggle`

## Technical Stuff

<details>
<summary>config.yml</summary>
<pre>

    # MAIN SETTINGS
    checkForEmptySpace: true          # Makes sure there's space above the Chair before mounting it.
    ignoredEmptySpaceBlocks:          # If the checkForEmptySpace is true, these items will be ignored and count as empty space. If the block contains something from this list in this name it will be ignored.
      - AIR
      - BANNER
      - WALL_SIGN
      - BUTTON
      - LEVER
      - TORCH
      - TRIPWIRE
      - VINE
      - LADDER
    dismountAboveChair: true         # Dismounts above the Chair and not in the Chair.
    blacklistedWorlds:               # The Worlds that Chairs will not work on.
      - ExampleWorld
    
    #     ___ _         _          ___     _              _        _
    #    / __| |_  __ _(_)_ _ ___ | _ \___| |___  __ _ __| |___ __| |
    #   | (__| ' \/ _` | | '_(_-< |   / -_) / _ \/ _` / _` / -_) _` |
    #    \___|_||_\__,_|_|_| /__/ |_|_\___|_\___/\__,_\__,_\___\__,_|
    #
</pre>
</details>

## FAQ

- **Q**: Why Reloaded? \
  **A**: The original plugin was made by [ItsGeppy](https://github.com/Gepsu) and is now maintained by [HeadMonitor](https://github.com/HeadMonitor) for the [Nexia Network](https://www.playnexia.net/). Reloaded means the version that is maintained by [HeadMonitor](https://github.com/HeadMonitor) and not it's original creator.

- **Q**: I have an issue, found a bug or want to request a feature. \
  **A**: You can leave a comment on the [Discussion](https://blank.org) tab, or join our [Discord](https://blank.org) 
         server.
         
- **Q**: If I request a feature what are the chances of it being accepted? How long will it take to implement? \
  **A**: The chances are very high! We want the Plugin to be as much useful to you as possible. As for the time to implement
         this solely depends on the complexity of the feature, but it shouldn't take more than a few days!
---

<p align="center">
  <img src="https://user-images.githubusercontent.com/62361708/220228413-2fea94e2-f7fe-4708-84d7-f8ac6a7bec5f.png"/>
</p>
