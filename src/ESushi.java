import java.util.Arrays;
import java.util.List;

public enum ESushi {

    KappaMaki("Kappa Maki", EIngridients.Kappa, EIngridients.Rice, EIngridients.Nori),
    VegeFutomaki("Vege Futomaki", EIngridients.Kappa, EIngridients.Rice, EIngridients.Avocado, EIngridients.Oshinko,
            EIngridients.Nori, EIngridients.Kanpyo),
    GunkanCaviar("Gunkan Caviar", EIngridients.Caviar, EIngridients.Rice, EIngridients.Nori),
    SalmonMaki("Salmon Maki", EIngridients.Salmon, EIngridients.Rice, EIngridients.Nori),
    OshinkoMaki("Oshinko Maki", EIngridients.Oshinko, EIngridients.Rice, EIngridients.Nori),
    KanpyoMaki("Kanpyo Maki", EIngridients.Kanpyo, EIngridients.Rice, EIngridients.Nori),
    IbodaNigiri("Iboda Nigiri", EIngridients.ButterFish, EIngridients.Rice),
    PhiledelphiaSalmonMaki("Philadelphia Salmon Maki", EIngridients.Salmon, EIngridients.Avocado, EIngridients.Rice, EIngridients.Nori)

;
    private String name;
    private List<EIngridients> ingridientsList;

    private ESushi(String name, EIngridients... ingridients) {
        this.name = name;
        this.ingridientsList = Arrays.asList(ingridients);

    }
    public String getName(){
        return name;
    }

    public List<EIngridients> getIngridientsList(){
        return ingridientsList;
    }
}
