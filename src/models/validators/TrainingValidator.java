package models.validators;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import models.Training;

public class TrainingValidator {
    public static List<String> validate(Training t){
        List<String> errors = new ArrayList<String>();

        String training_date_error = _validateTrainingDate(t.getTraining_date());
        if(!training_date_error.equals("")){
            errors.add(training_date_error);
        }

        String pushup_error = _validatePushup(t.getPushup());
        if(!pushup_error.equals("")){
            errors.add(pushup_error);
        }

        String kensui_error = _validateKensui(t.getKensui());
        if(!kensui_error.equals("")){
            errors.add(kensui_error);
        }

        String sideraise_error = _validateSideraise(t.getSideraise());
        if(!sideraise_error.equals("")){
            errors.add(sideraise_error);
        }

        String abs_error = _validateAbs(t.getAbs());
        if(!abs_error.equals("")){
            errors.add(abs_error);
        }

        String squat_error = _validateSquat(t.getSquat());
        if(!squat_error.equals("")){
            errors.add(squat_error);
        }

        return errors;
    }

    private static String _validateTrainingDate(Date date){
        if(date == null || date.equals("")){
            return "日付を入力してください。";
        }

        return "";
    }

    private static String _validateKensui(Integer kensui){
        if(kensui == null || kensui.equals("")){
            return "懸垂を入力してください。";
        }

        return "";
    }

    private static String _validateSideraise(Integer sideraise){
        if(sideraise == null || sideraise.equals("")){
            return "サイドレイズを入力してください。";
        }

        return "";
    }

    private static String _validatePushup(Integer pushup){
        if(pushup == null || pushup.equals("")){
            return "腕立てを入力してください。";
        }

        return "";
    }

    private static String _validateAbs(Integer abs){
        if(abs == null || abs.equals("")){
            return "腹筋を入力してください。";
        }

        return "";
    }

    private static String _validateSquat(Integer squat){
        if(squat == null || squat.equals("")){
            return "スクワットを入力してください。";
        }

        return "";
    }

}
