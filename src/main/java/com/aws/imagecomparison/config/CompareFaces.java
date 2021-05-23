package com.aws.imagecomparison.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

@Component
public class CompareFaces {
    public Object compareFaces(String img1, String img2) throws IOException {
        Properties prop = new Properties();
        InputStream inputStream = new FileInputStream("src/main/resources/application.properties");
        prop.load(inputStream);
        String photo1 = prop.getProperty("source_image")+img1;
        String photo2 = prop.getProperty("target_image")+img2;
        ClientConfiguration clientConfig = createClientConfiguration();
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(prop.getProperty("accessKey"),
                prop.getProperty("secretKey"));

        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder
                .standard()
                .withClientConfiguration(clientConfig)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion("ap-south-1").build();

        CompareFaces compareFaces = new CompareFaces();
        ByteBuffer image1 = compareFaces.loadImage(photo1);
        ByteBuffer image2 = compareFaces.loadImage(photo2);
        if (image1 == null || image2 == null) {
            return null;
        }

        CompareFacesRequest compareFacesRequest = new CompareFacesRequest()
                .withSourceImage(new Image().withBytes(image1)).withTargetImage(new Image().withBytes(image2))
                .withSimilarityThreshold(70F);

        try {

            CompareFacesResult result = rekognitionClient.compareFaces(compareFacesRequest);
            List<CompareFacesMatch> lists = result.getFaceMatches();

            System.out.println("Detected labels for " + photo1 + " and " + photo2);

            if (!lists.isEmpty()) {
                for (CompareFacesMatch label : lists) {
                    //System.out.println(label.getFace() + ": Similarity is " + label.getSimilarity().toString());
                    System.out.println("Similarity is " + label.getSimilarity().toString());
                }
                //return lists;
                return "Faces matched "+lists.get(0).getSimilarity().intValue() + "%" ;
            } else {
                return "Faces Does not match";
            }
        } catch (AmazonRekognitionException e) {
            e.printStackTrace();
        }
        inputStream.close();
        return null;
    }

    private ByteBuffer loadImage(String imgPath) {
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(Paths.get(imgPath));
        } catch (IOException e) {
            System.err.println("Failed to load image: " + e.getMessage());
            return null;
        }
        return ByteBuffer.wrap(bytes);
    }

    private static ClientConfiguration createClientConfiguration() {
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setConnectionTimeout(30000);
        clientConfig.setRequestTimeout(60000);
        clientConfig.setProtocol(Protocol.HTTPS);
        return clientConfig;
    }
}
