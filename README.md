<div align="center">
 <img src="https://user-images.githubusercontent.com/62361708/224350839-5483032d-8053-4797-ae60-fba44476ce73.png" width=256>
</div>

Minecraft plugin that allows players to sit on Stairs and Slabs.

Uses [NexiaAPI](https://github.com/NexiaDevelopers/NexiaAPI) and [ACF](https://github.com/aikar/commands).

Originally developed by [ItsGeppy](https://github.com/Gepsu) and maintained by [HeadMonitor](https://github.com/HeadMonitor) for the [Nexia Network](https://www.playnexia.net/).

<div align="center">
 <img src="https://user-images.githubusercontent.com/62361708/224358914-2c5eda3f-4843-4edc-8d83-d64247e30ae6.png" width=400>
 <img src="https://user-images.githubusercontent.com/62361708/224359015-359ab709-c6f9-49a8-b815-36e8e366c33c.png" width=400>
</div>

<div align="center">
 <img src="https://user-images.githubusercontent.com/62361708/225291005-6b6bf7df-50bf-48f6-acbe-d50772ee865a.png">
</div>

Just place the .jar file in your plugins folder and the plugin should work! Easy as that! After that you can configure the the plugin from the `config.yml` to your needs.

<div align="center">
 <img src="https://user-images.githubusercontent.com/62361708/225288203-3f8324f9-5a02-4156-9159-b13429466559.png">
</div>

- `/chairs toggle` Toggles the ability to sit on Stairs and Slabs on or off. This is helpful if Players are building with those blocks. 

<div align="center">
 <img src="https://user-images.githubusercontent.com/62361708/225288290-f1b60d76-9af8-40f6-90d3-c5a6083cf661.png">
</div>

- `nexia.chairsreloaded.chairs.toggle`

<div align="center">
 <img src="https://user-images.githubusercontent.com/62361708/225288387-3b514380-63ec-467d-95c0-c0ebd76105ac.png">
</div>

<details>
<summary>config.yml</summary>
<pre>

```yaml
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
    
    #     ____ _           _            ____      _                 _          _ 
    #    / ___| |__   __ _(_)_ __ ___  |  _ \ ___| | ___   __ _  __| | ___  __| |
    #   | |   | '_ \ / _` | | '__/ __| | |_) / _ \ |/ _ \ / _` |/ _` |/ _ \/ _` |
    #   | |___| | | | (_| | | |  \__ \ |  _ <  __/ | (_) | (_| | (_| |  __/ (_| |
    #    \____|_| |_|\__,_|_|_|  |___/ |_| \_\___|_|\___/ \__,_|\__,_|\___|\__,_|
    #                                                                            
```
</pre>
</details>

<div align="center">
 <img src="https://user-images.githubusercontent.com/62361708/225434090-dce1fb3c-9ff6-43e9-80c3-76ac800ad7f5.png">
</div>

You can get **Support**, **Request a Feature** or **Report a Bug** through the [Discussion](https://blank.org) tab or through our [Discord](https://blank.org). We will do our best to help you out!

<div align="center">
 <img src="https://user-images.githubusercontent.com/62361708/225288503-a789afa0-4be5-4ff4-a83f-9d28c4dda1ed.png">
</div>

- **Q**: Why Reloaded? \
  **A**: The original plugin was made by [ItsGeppy](https://github.com/Gepsu) and is now maintained by [HeadMonitor](https://github.com/HeadMonitor) for the [Nexia Network](https://www.playnexia.net/). Reloaded means the version that is maintained by [HeadMonitor](https://github.com/HeadMonitor) and not it's original creator.

- **Q**: I have an issue, found a bug or want to request a feature. \
  **A**: You can leave a comment on the [Discussion](https://blank.org) tab, or join our [Discord](https://blank.org) 
         server.
         
- **Q**: If I request a feature what are the chances of it being accepted? How long will it take to implement? \
  **A**: The chances are very high! We want the Plugin to be as much useful to you as possible. As for the time to implement
         this solely depends on the complexity of the feature, but it shouldn't take more than a few days!

<div align="center">
 <img src="https://user-images.githubusercontent.com/62361708/225291382-810daed4-d1d1-4459-b9b3-3ac7fa5713d2.png">
</div>

- Versions priot to **1.14** will not save the player's toggle state on server restarts.
- Versions prior to **1.13** are not supported since SpigotAPI is missing features that the plugin uses.

<div align="center">
 <img src="https://user-images.githubusercontent.com/62361708/225436833-ae8c3941-335e-452b-aa48-7cc490ee4a11.png">
</div>

<p align="center">
  <img src="https://user-images.githubusercontent.com/62361708/220228413-2fea94e2-f7fe-4708-84d7-f8ac6a7bec5f.png"/>
</p>
