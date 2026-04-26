package CritterControl.Commands;

import CritterControl.Accessories.Accessory;
import CritterControl.CritterCorral;
import CritterControl.critters.Critter;
import CritterControl.critters.CritterFactory;
import org.slf4j.Logger;

public class DressCommand extends Command {
    static Logger logger = org.slf4j.LoggerFactory.getLogger(DressCommand.class);

    private final static CritterFactory critterFactory = new CritterFactory();

    private final CritterCorral corral;
    private final Accessory accessory;

    public DressCommand(Critter critter, CritterCorral corral, Accessory accessory) {
        super(CommandType.DRESS, critter);
        this.corral = corral;
        this.accessory = accessory;
    }

    @Override
    public boolean execute() {
        Critter accessorizedCritter = critterFactory.createAccessorizedCritter(critter, getAccessory());
        if (critter.isAccessorized()) {
            corral.add(critter.getAccessory());
        }

        corral.replace(critter, accessorizedCritter);
        logger.info("{} put on: {}", critter.getName(), accessory);
        return true;
    }

    private Accessory getAccessory() {
        if (!corral.contains(accessory)) {
            logger.warn("Accessory not in wardrobe");
        }
        corral.remove(accessory);
        return accessory;
    }
}
