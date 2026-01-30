package cz.macek.knight.data;

public class ItemData {


        private String id;
        private String type;
        private String name;
        private String description;


       private Integer damage;
       private Integer defense;
       private Integer blockPower;
       private Integer partNumber;

       public String getId() { return id; }
       public String getName() { return name; }

       public Integer getDamage() { return damage; }
       public Integer getDefense() { return defense; }
       public Integer getBlockPower() { return blockPower; }
       public Integer getPartNumber() { return partNumber; }




        public void setId(String id) {
            this.id = id;
        }



        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }



        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

