import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class CourseTypeConverter implements AttributeConverter<CourseType, Integer> {


    @Override
    public Integer convertToDatabaseColumn(CourseType type) {
        if(type == null){
            return null;
        }
        switch (type) {
            case DESIGN:
                return 1;
            case BUSINESS:
                return 2;
            case PROGRAMMING:
                return 3;
            case MARKETING:
                return 4;
            case MANAGEMENT:
                return 5;
            default:
                throw new IllegalArgumentException(type + " не поддерживается.");
        }
    }

    @Override
    public CourseType convertToEntityAttribute(Integer dbData) {
        if(dbData == null){
            return null;
        }
        switch (dbData) {
            case 1:
                return CourseType.DESIGN;
            case 2:
                return CourseType.BUSINESS;
            case 3:
                return CourseType.PROGRAMMING;
            case 4:
                return CourseType.MARKETING;
            case 5:
                return CourseType.MANAGEMENT;
            default:
                throw new IllegalArgumentException(dbData + " не поддерживается.");
        }
    }
}
