package com.RetroZoomer.KP_Android.service;

import com.RetroZoomer.KP_Android.entity.character.Attack;
import com.RetroZoomer.KP_Android.entity.character.Character;
import com.RetroZoomer.KP_Android.repository.AttackRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttackService {
    @Autowired
    AttackRep attackRep;

    public Attack findAttackById(Long id) {
        Optional<Attack> AttackFromDb = attackRep.findById(id);
        return AttackFromDb.orElse(new Attack());
    }

    public List<Attack> findAllAttacks() {
        return attackRep.findAll();
    }

    public Attack saveAttack(Attack attack) {
        return attackRep.save(attack);
    }

    public Attack updateAttack(Attack attack) {
        return attackRep.save(attack);
    }

    public void deleteAttack(Long id) {
        attackRep.deleteById(id);
    }
}
