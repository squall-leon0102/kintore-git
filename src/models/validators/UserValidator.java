package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.User;
import utils.DBUtil;

public class UserValidator {
    public static List<String> validate(User u, Boolean name_duplicate_check_flag, Boolean password_check_flag){
        List<String> errors = new ArrayList<String>();

        String name_error = _validateName(u.getName(), name_duplicate_check_flag);
        if(!name_error.equals("")){
            errors.add(name_error);
        }

        String password_error = _validatePassword(u.getPassword(),password_check_flag);
        if(!password_error.equals("")){
            errors.add(password_error);
        }
        return errors;

    }

    private static String _validateName(String name, Boolean name_duplicate_check_flag){

        if(name == null || name.equals("")){
            return "氏名を入力してください。";

        }

        if(name_duplicate_check_flag) {
            EntityManager em = DBUtil.createEntityManager();
            long users_count = (long)em.createNamedQuery("checkRegisteredName", Long.class)
                                           .setParameter("name", name)
                                             .getSingleResult();
            em.close();
            if(users_count > 0) {
                return "入力された氏名の情報はすでに存在しています。";
            }
        }

        return "";
    }

    private static String _validatePassword(String password, Boolean password_check_flag){

        if(password_check_flag && (password == null || password.equals(""))){
            return "パスワードを入力してください";
        }

        return "";

    }
}
