package com.RetroZoomer.KP_Android.entity.character;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@Table(name = "`character`")
public class Character implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String name;
    private String race;
    private String nameClass;
    private String img;
    private int level;
    private int AC; // класс брони
    private int XP;
    private int speed;
    private int initiative;
    private boolean inspiration; // вдохновение
    private int proficiency; // бонус мастерства
    // здоровье
    private int realHP;
    private int maxHP;
    private int bonusHP;

    // характеристики
    private int strength; // сила
    private int dexterity; // ловкость
    private int constitution; // телосложение
    private int intelligence; // телосложение
    private int wisdom; // телосложение
    private int charisma; // телосложение
    // спасброски
    private boolean strengthSav;
    private boolean dexteritySav;
    private boolean constitutionSav;
    private boolean intelligenceSav;
    private boolean wisdomSav;
    private boolean charismaSav;
    // умения
    private boolean acrobatics;
    private boolean animalHandling;
    private boolean arcana;
    private boolean athletics;
    private boolean deception;
    private boolean history;
    private boolean insight;
    private boolean intimidation;
    private boolean investigation;
    private boolean medicine;
    private boolean nature;
    private boolean perception;
    private boolean performance;
    private boolean persuasion;
    private boolean religion;
    private boolean sleightOfHand;
    private boolean stealth;
    private boolean survival; // bite
    // атаки
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(	name = "character_attack",
//            joinColumns = @JoinColumn(name = "character_id"),
//            inverseJoinColumns = @JoinColumn(name = "attack_id"))
//    private Set<Attack> attacks = new HashSet<>();
    private String attacksAndSpells;
    private String skillsAndAbilities;
    // заклинания
    private String spellCharacteristic;
//    private byte count_1L;
//    private byte count_2L;
//    private byte count_3L;
//    private byte count_4L;
//    private byte count_5L;
//    private byte count_6L;
//    private byte count_7L;
//    private byte count_8L;
//    private byte count_9L;

    private String spell_1L;
    private String spell_2L;
    private String spell_3L;
    private String spell_4L;
    private String spell_5L;
    private String spell_6L;
    private String spell_7L;
    private String spell_8L;
    private String spell_9L;
    // доп способности
    private String additionalAbilities;
    // снаряжение и сокровища
    private int gold;
    private String equipment;
    private String treasures;
    // прочие владения и языки
    private String additionalProficiencyAndLanguages;
    // личность и внешность
    private String background;
    private String personality;
    // заметки
    private String notes_1;
    private String notes_2;
    private String notes_3;
    private String notes_4;
    private String notes_5;
}
