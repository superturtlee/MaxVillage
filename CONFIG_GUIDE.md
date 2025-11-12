# MaxVillage Configuration Guide

MaxVillage is a Minecraft 1.16.5 mod that allows you to configure the generation frequency and minimum distances of naturally generated structures like villages, temples, and more.

## Configuration File Location

After running Minecraft with this mod installed for the first time, a configuration file will be generated at:
```
<minecraft_directory>/config/maxvillage-common.toml
```

## Configuration Options

The configuration file allows you to adjust two key parameters for each structure type:

- **Spacing**: The average distance between structures (in chunks). Higher values mean structures spawn less frequently.
- **Separation**: The minimum distance between structures (in chunks). This ensures structures don't spawn too close to each other.

### Supported Structures

The mod supports configuration for the following structures:

#### Overworld Structures
1. **Village**
   - Default Spacing: 32 chunks
   - Default Separation: 8 chunks

2. **Desert Pyramid**
   - Default Spacing: 32 chunks
   - Default Separation: 8 chunks

3. **Jungle Temple**
   - Default Spacing: 32 chunks
   - Default Separation: 8 chunks

4. **Swamp Hut (Witch Hut)**
   - Default Spacing: 32 chunks
   - Default Separation: 8 chunks

5. **Igloo**
   - Default Spacing: 32 chunks
   - Default Separation: 8 chunks

6. **Ocean Monument**
   - Default Spacing: 32 chunks
   - Default Separation: 5 chunks

7. **Shipwreck**
   - Default Spacing: 24 chunks
   - Default Separation: 4 chunks

8. **Ocean Ruins**
   - Default Spacing: 20 chunks
   - Default Separation: 8 chunks

9. **Pillager Outpost**
   - Default Spacing: 32 chunks
   - Default Separation: 8 chunks

10. **Woodland Mansion**
    - Default Spacing: 80 chunks
    - Default Separation: 20 chunks

#### Nether Structures
11. **Nether Fortress**
    - Default Spacing: 27 chunks
    - Default Separation: 4 chunks

#### End Structures
12. **End City**
    - Default Spacing: 20 chunks
    - Default Separation: 11 chunks

## Example Configuration

Here's an example of how your `maxvillage-common.toml` file will look:

```toml
[structures]
    #Village Generation Settings
    #Spacing: Average distance between villages (in chunks)
    #Separation: Minimum distance between villages (in chunks)
    [structures.village]
        #Default: 32
        #Range: 1 ~ 1000
        spacing = 32
        #Default: 8
        #Range: 1 ~ 1000
        separation = 8

    #Desert Pyramid Generation Settings
    [structures.desert_pyramid]
        #Default: 32
        #Range: 1 ~ 1000
        spacing = 32
        #Default: 8
        #Range: 1 ~ 1000
        separation = 8
    
    # ... (other structures follow the same pattern)
```

## How to Use

1. **Install the mod**: Place the MaxVillage JAR file in your Minecraft `mods` folder
2. **Run Minecraft**: Start Minecraft with Forge 1.16.5 to generate the default configuration
3. **Edit configuration**: Modify the values in `config/maxvillage-common.toml` to your preferences
4. **Restart Minecraft**: Changes will take effect after restarting the game
5. **Create a new world**: Configuration changes only affect newly generated chunks/worlds

## Tips and Recommendations

### Making Villages More Common
To find villages more easily:
```toml
[structures.village]
    spacing = 16    # Halve the default spacing
    separation = 4  # Halve the default separation
```

### Making Villages More Rare
To make villages rarer and more special to find:
```toml
[structures.village]
    spacing = 64    # Double the default spacing
    separation = 16 # Double the default separation
```

### Making Mansions More Common
Woodland Mansions are very rare by default. To make them easier to find:
```toml
[structures.mansion]
    spacing = 40    # Half the default spacing
    separation = 10 # Half the default separation
```

### Performance Considerations
- Lower spacing/separation values mean more structures, which can impact world generation performance
- Higher values mean fewer structures, which can improve performance but make exploration less rewarding

## Important Notes

- **Chunk Size**: A chunk in Minecraft is 16x16 blocks
- **World Generation**: These settings only affect new chunks that haven't been generated yet
- **Existing Worlds**: To see changes in an existing world, you need to explore new areas that haven't been generated
- **Multiplayer**: The server's configuration file is used; client configs are ignored
- **Valid Range**: All spacing and separation values must be between 1 and 1000

## Troubleshooting

**Q: My changes aren't working!**
- Make sure you've restarted Minecraft after editing the config
- Remember that existing chunks won't change - you need to explore new areas
- Check that your values are within the valid range (1-1000)

**Q: Can I disable a structure entirely?**
- Setting separation equal to or greater than spacing will make structures extremely rare but not disable them entirely

**Q: Will this work on multiplayer servers?**
- Yes! The server admin needs to install the mod and configure it. All connected clients will use the server's settings.

## Version Compatibility

This mod is designed for:
- Minecraft: 1.16.5
- Forge: 36.2.42

## Support

For issues, questions, or suggestions, please visit the mod's GitHub repository at https://github.com/superturtlee/MaxVillage

## Credits

This mod was developed to make structure exploration in Minecraft more customizable and accessible to all players.
